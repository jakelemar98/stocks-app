const grpc = require('grpc');
var services = require('./proto/email_grpc_pb');
var calls = require("./rpcCalls")

function main() {
    const server = new grpc.Server();

    server.addService(services.EmailServiceService, {verifyEmail: calls.VerifyEmail})
    server.bind('0.0.0.0:5001', grpc.ServerCredentials.createInsecure());
    console.log('Server running at 0.0.0.0:5001');
    server.start();
}

main();
