const grpc = require('grpc');

var emailer = require('./emailer')
var messages = require('./proto/email_pb');
var services = require('./proto/email_grpc_pb');

function SendMail(call, callback) {           
    emailer.sendEmail(
            call.request.array[0][0],
            call.request.array[0][1],
            call.request.array[0][2]
        )
    var reply = new messages.EmailReply();
    reply.setReply('hello email');
    callback(null, reply)
}

function main() {
    const server = new grpc.Server();

    server.addService(services.EmailServiceService, {sendMail: SendMail})
    server.bind('127.0.0.1:5001', grpc.ServerCredentials.createInsecure());
    console.log('Server running at 0.0.0.0:5001');
    server.start();
}

main();
