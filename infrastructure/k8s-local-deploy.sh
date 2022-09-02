echo "------------------------------------------------------------"
echo "Building car owner service"
echo "------------------------------------------------------------"
cd ../car-owner-service
mvn clean install

echo ""
echo "------------------------------------------------------------"
echo "Building car owner ui"
echo "------------------------------------------------------------"
cd ../car-owner-ui
npm install
npm run build

echo ""
echo "------------------------------------------------------------"
echo "Building images"
echo "------------------------------------------------------------"
cd ../jkube-test
mvn clean k8s:build k8s:push

echo ""
echo "------------------------------------------------------------"
echo "Applying k8s config"
echo "------------------------------------------------------------"
kubectl apply -f ./src/k8s