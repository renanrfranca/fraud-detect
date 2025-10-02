# **Project challenges**

## Proper Kafka setup.

I had a ton of issues setting up Kafka for development. The main issue was the correct setup for the number of brokers and the proper configuration values. Settings like "topic replication factor" defaults to 3, which doesn't work with a single node approach and the logs are very much vague about it. I've tried running 3 separate containers but ran into race condition issues and it seemed overkill for this early development phase. I might revisit this later.