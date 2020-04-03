FROM python:3.6-slim as base

FROM base AS compile-image
RUN apt-get update \
  && apt-get install -y --no-install-recommends \
  build-essential \
  gcc

RUN python -m venv /app/env
ENV PATH="/app/env/bin:$PATH"

COPY requirements.txt .
RUN pip install --upgrade pip
RUN pip install -r requirements.txt

FROM base AS build-image
COPY --from=compile-image /app/env /app/env

ENV PATH="/app/env/bin:$PATH"
WORKDIR /app/python
COPY . /app
EXPOSE 8001
CMD ["python", "./userServer.py"]
