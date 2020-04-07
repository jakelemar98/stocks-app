# Imports the Google Cloud client library
from google.cloud import datastore

# Instantiates a client
datastore_client = datastore.Client(namespace="test")
# The kind for the new entity
kind = 'user'
# The name/ID for the new entity
id = 'jtemple'
# The Cloud Datastore key for the new entity
user_key = datastore_client.key(kind, id)

# Prepares the new entity
user = datastore.Entity(key=user_key)
user['email'] = 'temple2679@gmail.com'
user['first'] = 'Jack'
user['last'] = 'Temple'
# just for test, will wont to hash the password when done
user['password'] = 'testPassword'
# Saves the entity
datastore_client.put(user)

print('Saved {}: {}'.format(user.key.name, user))