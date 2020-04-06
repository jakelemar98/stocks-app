files_array=(../stocks-app/src/environments/environment.ts)

API_ENDPOINT=https://test.gateway.stocks4fun.com

if [ $1 = "feat" ] ; then
    API_ENDPOINT=https://$2.feat.gateway.stocks4fun.com
fi
 
export API_ENDPOINT=$API_ENDPOINT

for i in "${files_array[@]}"
do
    :
    envsubst<$i >./$i.out
    mv $i.out $i
done