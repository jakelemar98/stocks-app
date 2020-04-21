const { MongoClient } = require('mongodb');
const Verify = require('./verifyEmail');

class MongoBot {
  constructor() {
    const url = "mongodb+srv://user-service:lFWXM1Icmscg4RCE@stocks-cluster-ciiim.gcp.mongodb.net/test?retryWrites=true&w=majority";

    this.client = new MongoClient(url);
  }
  async init() {
    await this.client.connect();
    console.log('connected');
    this.db = this.client.db("email-database");
    this.Verify = new Verify(this.db)
  }
}

module.exports = new MongoBot();