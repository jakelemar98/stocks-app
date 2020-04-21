var messages = require('./proto/users_pb');
var services = require('./proto/users_grpc_pb');

var grpc = require('grpc');

    var client = new services.UserServiceClient('user-service:8001', grpc.credentials.createInsecure());
    var request = new messages.VerifyUserRequest();

    function verifyUser(id, callback) {
        
        request.setId(id)
        var response = client.verifyUser(request, (err, response) => {
            if (response) {                
                callback(response.getStatus(), response.getToken())
            } else {
                callback(err)
            }
        })
    }




module.exports = { verifyUser }