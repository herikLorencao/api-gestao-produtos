package:
	@ ./mvnw clean package

docker-image-build: package
	@ docker build -t herik-lorencao/gestao-produtos .

run: docker-image-build
	@ docker-compose up -d

stop:
	@ docker-compose down -v