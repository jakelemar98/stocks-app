from google.cloud import datastore
import bcrypt
import json

datastore_client = datastore.Client(namespace="test")
kind = 'user'

def createUser(request):
    id = request.email
    
    user_key = datastore_client.key(kind, id)

    user = datastore.Entity(key=user_key)
    user['email'] = request.email
    user['first'] = request.firstname
    user['last'] = request.lastname

    hashPW = hashPassword(request.password)

    user['password'] = hashPW
    # Saves the entity
    datastore_client.put(user)

    del user['password']

    userJson = json.dumps(user)
    return userJson

def hashPassword(password):
    # Hash a password for the first time, with a randomly-generated salt
    hashed = bcrypt.hashpw(password, bcrypt.gensalt())
    return hashed

def checkPass(password, hash):
    # previously been hashed
    if bcrypt.hashpw(password, hash) == hash:
            print ("It matches")
    else:
            print ("It does not match")
