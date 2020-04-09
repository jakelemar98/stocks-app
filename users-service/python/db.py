import bcrypt
import json
import pymongo
import encoder

client = pymongo.MongoClient("mongodb+srv://user-service:lFWXM1Icmscg4RCE@stocks-cluster-ciiim.gcp.mongodb.net/test?retryWrites=true&w=majority")
db = client["app-database"]
collection = db["users"]

def createUser(request):

    query = { "email": request.email }

    check_email = collection.find(query).count()

    if check_email > 0:
        return "email already exists", 400       

    user = {
        "first": request.firstname,
        "last": request.lastname,
        "email": request.email,
        "password": hashPassword(request.password)
    }

    result = collection.insert_one(user)

    result = encoder.JSONEncoder().encode(result.inserted_id)

    return result, 201
    
   

def getUser(request):
    id = request.email

    query = { "email": request.email }

    user = collection.find(query).count()

    if user == 0:
        return "email does not exist", 404

    user = collection.find_one(query)

    if not checkPass(request.password, user['password']):
        return "wrong password", 401

    user.pop('password')

    result = encoder.JSONEncoder().encode(user)

    return result, 200

def hashPassword(password):
    # Hash a password for the first time, with a randomly-generated salt
    hashed = bcrypt.hashpw(password, bcrypt.gensalt())
    return hashed

def checkPass(password, hash):
    # previously been hashed
    if bcrypt.hashpw(password, hash) == hash:
            return True
    else:
            return False
