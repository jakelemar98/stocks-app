var emailer = require('./emailer')
var messages = require('./proto/email_pb');
var logic = require('./logic')

module.exports = {
    VerifyEmail: function (call, callback) {  
        var code = logic.verifyLogic(call.request.array[0 ])         
        var email = emailer.sendEmail(
            call.request.array[1],
            "Please Verify Your Email",
            "Here is your verification code: " + code,
            function(info, err){
                var reply = new messages.EmailReply();
                if (!err) {
                    reply.setBody(info.accepted[0]);
                    reply.setStatus(200);
                    callback(null, reply);
                } else {
                    reply.setBody("Email was not sent");
                    reply.setStatus(422);
                    callback(null, reply)
                }
                
            }
        )
    },
    CheckVerified: function (call, callback) {
        console.log(call);
        var reply = new messages.EmailReply()
        reply.setBody("hey call works")
        reply.setStatus(200)
        callback(null, reply)
    }
}