const db = require('./db');
const userService = require('./userClient');
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
    },
    
    checkLogic: async function (args, callback) {
        const rpc = require('./rpcCalls');
        var id = args[0];
        var code = args[1];

        id = id.substring(1, id.length - 1)        
        var record = await db.checkVerified(id)
        if (!record) {
            rpc.CheckResult(["user verification does not exist", 401], callback)
        }        
        var time = new Date();
        time = time.getTime();

        if (!(time < record.expiration)) {
            rpc.CheckResult(["expired code", 419], callback)
        }        

        if (code === record.code) {
            this.verifyUserLogic(id, async res => {
                console.log(res);
                if (res === 200) {
                    await db.deleteVerified(id)
                    rpc.CheckResult(["code is correct, account verified", 200], callback)
                } else {
                    rpc.CheckResult(['user could not be verified', 500], callback)
                }
            })
        } else {
            rpc.CheckResult["code is incorrect", 401]
        }
    },

    verifyUserLogic: function (id, calllback) {
        userService.verifyUser(id, res => {
            calllback(res);
        })
    }
}