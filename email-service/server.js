const grpc = require('grpc');
var services = require('./proto/email_grpc_pb');
var calls = require("./rpcCalls")
const mongo = require('./mongo')

async function main() {
    const server = new grpc.Server();
    await mongo.init();
    server.addService(services.EmailServiceService, {verifyEmail: calls.VerifyEmail, checkVerified: calls.CheckVerified})
    server.bind('0.0.0.0:5001', grpc.ServerCredentials.createInsecure());
    console.log('Server running at 0.0.0.0:5001');
    server.start();
}

main();
