FROM python:3.6-onbuild

WORKDIR /app/python

ADD . /app

RUN python -m pip install grpcio
RUN python -m pip install grpcio-tools

CMD ["python", "./userServer.py"]