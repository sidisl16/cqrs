docker run --name mongodb -p 27017:27017 --network techbanknet -v mongodb_data:/data/db -d mongodb/mongodb-community-server:latest
