FROM alpine
RUN apk add openjdk8
WORKDIR /usr/share/sriram
ADD Test.java Test.java
ENTRYPOINT javac Test.java && java Test $NUMBER
