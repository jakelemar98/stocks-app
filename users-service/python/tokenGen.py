from datetime import datetime, timedelta
import jwt
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

JWT_SECRET = 'secret'
JWT_ALGORITHM = 'RS256'
JWT_EXP_DELTA_SECONDS = 3600

with open("rsa_private.pem", "rb") as key_file:
    private_key = serialization.load_pem_private_key(
        key_file.read(),
        password=None,
        backend=default_backend()
    )


def createJWT(user_id, user):
    payload = {
        'user_id': user_id,
        'first': user['first'],
        'last': user['last'],
        'email': user['email'],
        'exp': datetime.utcnow() + timedelta(seconds=JWT_EXP_DELTA_SECONDS)
    }
    jwt_token = jwt.encode(payload, private_key, JWT_ALGORITHM)
    return jwt_token
