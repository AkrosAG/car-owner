echo "------------------------------------------------------------"
echo "Building car owner service"
echo "------------------------------------------------------------"
#cd ../car-owner-service
#mvn clean install

echo ""
echo "------------------------------------------------------------"
echo "Building car owner ui"
echo "------------------------------------------------------------"
#cd ../car-owner-ui
#npm install
#npm run build

echo ""
echo "------------------------------------------------------------"
echo "Building images"
echo "------------------------------------------------------------"
cd ../jkube-test
#eval $(minikube docker-env)
mvn clean k8s:build k8s:resource k8s:push k8s:apply