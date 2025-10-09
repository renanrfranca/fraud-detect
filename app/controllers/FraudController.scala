package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.bson.{BSONDocument, BSONString, BSONReader}  // Add BSONReader for implicit
import reactivemongo.api.ReadPreference  // Optional, for explicit if needed
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import reactivemongo.api.bson.collection.BSONCollection
import play.api.libs.json.Json

import reactivemongo.play.json.compat._,
  json2bson.{toDocumentReader, toDocumentWriter}
import models.User
import reactivemongo.api.Cursor
import models.Transaction

class FraudController @Inject() (
  components: ControllerComponents,
  val reactiveMongoApi: ReactiveMongoApi
) extends AbstractController(components) {

    implicit def ec: ExecutionContext = components.executionContext

    def testUsers = Action.async {
        val cursor = reactiveMongoApi.database.map(_.collection[BSONCollection]("users")).map {
            _.find(Json.obj("usualLocation" -> "US")).cursor[User]()
        }

        val futureUsersList: Future[List[User]] =
            cursor.flatMap(_.collect[List](-1, Cursor.FailOnError[List[User]]()))
            

        futureUsersList.map { persons =>
            Ok(persons.toString)
        }
    }

    def testTransactions = Action.async {
        val cursor = reactiveMongoApi.database.map(_.collection[BSONCollection]("transactions")).map {
            _.find(Json.obj("countryCode" -> "US")).cursor[Transaction]()
        }

        val futureTransactionList: Future[List[Transaction]] =
            cursor.flatMap(_.collect[List](-1, Cursor.FailOnError[List[Transaction]]()))
            

        futureTransactionList.map {transaction =>
            Ok(transaction.toString)
        }
    }
}