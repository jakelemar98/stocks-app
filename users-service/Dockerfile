FROM python:3.6-onbuild

ADD . .

RUN python -m pip install grpcio
RUN python -m pip install grpcio-tools

CMD ["python", "./userServer.py"]