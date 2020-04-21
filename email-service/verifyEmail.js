class VerifyEmail {
    constructor(db) {
      this.collection = db.collection('verified');
    }

    async addVerified(verified) {            
      var query = { id: verified.id }
      const existing = await this.collection.deleteOne(query)

      const newVerified = await this.collection.insertOne(verified);
      return newVerified;
    }

    async checkVerified(id) {
      var query = { id: id }
      const verified = await this.collection.findOne(query);
      return verified
    }
  }
  module.exports = VerifyEmail;