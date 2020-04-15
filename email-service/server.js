const grpc = require('grpc');

var emailer = require('./emailer')
var messages = require('./proto/email_pb');
var services = require('./proto/email_grpc_pb');

function VerifyEmail(call, callback) {           
    emailer.sendEmail(
            call.request.array[1],
            "Please Verify Your Email",
            "code will go here"
        )

    var reply = new messages.EmailReply();
    reply.setBody("not working yet");
    reply.setStatus(200);
    callback(null,reply)
}

function main() {
    const server = new grpc.Server();

    server.addService(services.EmailServiceService, {verifyEmail: VerifyEmail})
    server.bind('0.0.0.0:5001', grpc.ServerCredentials.createInsecure());
    console.log('Server running at 0.0.0.0:5001');
    server.start();
}

main();
