import bcrypt
import json
import pymongo
import encoder
import tokenGen

client = pymongo.MongoClient("mongodb+srv://user-service:lFWXM1Icmscg4RCE@stocks-cluster-ciiim.gcp.mongodb.net/test?retryWrites=true&w=majority")
db = client["app-database"]
collection = db["users"]

def createUser(request):

    query = { "email": request.email }

    check_email = collection.find(query).count()

    if check_email > 0:
        return "email already exists", "",400       
    hashed = hashPassword(request.password)
    user = {
        "first": request.firstname,
        "last": request.lastname,
        "email": request.email,
        "password": hashed
    }

    result = collection.insert_one(user)

    result = encoder.JSONEncoder().encode(result.inserted_id)

    token = tokenGen.createJWT(result, user)

    return result, token, 201
    
   

def getUser(request):
    query = { "email": request.email }

    user = collection.find(query).count()

    if user == 0:
        return "email does not exist", "", 404

    user = collection.find_one(query)

    if not checkPass(request.password, user['password']):
        return "wrong password", "", 401

    user.pop('password')

    result = encoder.JSONEncoder().encode(user)

    encoded_id = encoder.JSONEncoder().encode(user['_id'])

    token = tokenGen.createJWT(encoded_id, user)

    return result, token, 200

def hashPassword(password):
    # Hash a password for the first time, with a randomly-generated salt
    hashed = bcrypt.hashpw(password.encode(), bcrypt.gensalt())
    return hashed

def checkPass(password, hash):
    # previously been hashed
    if bcrypt.hashpw(password.encode(), hash) == hash:
            return True
    else:
            return False
