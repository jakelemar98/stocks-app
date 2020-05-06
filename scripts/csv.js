var fs = require('fs'),
    es = require('event-stream'),
    os = require('os');
var stockSymbols = []
var s = fs.createReadStream("nasdaq.txt")
    .pipe(es.split())
    .pipe(es.mapSync(function(line) {
        //pause the readstream
        s.pause();
        var symbol = line.substr(0, line.indexOf('\t'));
        var name = line.substr(line.indexOf('\t')+1);

        var array = {symbol, name}
        stockSymbols.push(array)        
        s.resume();
    })
    .on('error', function(err) {
        console.log('Error:', err);
    })
    .on('end', function() {
        console.log('Finish reading.');
        require('fs').writeFile(

          '../stocks-app/src/assets/data/stocks.json',
      
          JSON.stringify(stockSymbols),
      
          function (err) {
              if (err) {
                  console.error('Crap happens');
              }
          }
      );
    })
);