async function main() {
    const {MongoClient} = require('mongodb');

    const uri = "mongodb+srv://user-service:lFWXM1Icmscg4RCE@stocks-cluster-ciiim.gcp.mongodb.net/test?retryWrites=true&w=majority"
    
    const client = new MongoClient(uri);
    
    try {
        await client.connect();
    
        await listDatabases(client);
        
    } catch (e) {
        console.error(e);
    } finally {
        await client.close();
    }
}  

main().catch(console.error);


async function listDatabases(client){
    databasesList = await client.db().admin().listDatabases();
 
    console.log("Databases:");
    databasesList.databases.forEach(db => console.log(` - ${db.name}`));
};

