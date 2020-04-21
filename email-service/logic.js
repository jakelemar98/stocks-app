const db = require('./db')

module.exports = {
    verifyLogic: function (id) {
        var code = Math.floor(100000 + Math.random() * 900000);

        var cur = new Date();
        var expDate = new Date();

        expDate.setMinutes(cur.getMinutes()+60);
        expDate = expDate.getTime()
        id = id.substring(1, id.length - 1)        
        db.addVerify({"id": id, "code": code, "expiration": expDate})
        return code;
    }
}