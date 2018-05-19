var http = require("http"),
    exec = require('child_process').exec;

const PORT = 7788;

http.createServer(function (request, response) {
    if (request.url.search(/deploy\/?$/i) > 0) {
        var commands = [
            'supervisorctl stop tomcat',
            'sleep 3s',
            'supervisorctl start tomcat'
        ].join(' && ');
        var buildProcess = exec(commands, function (err, out, code) {
            if (err instanceof Error) {
                response.writeHead(500);
                response.end('Server Internal Error.');
                throw err
            }
            response.writeHead(200, {'Content-Type': 'text/plain'});
            response.end('Deploy Done.');
        });
        buildProcess.stdout.on('data', function (data) {
            console.log(data);
        });
    } else {
        response.writeHead(404);
        response.end('Not Found.')
    }

}).listen(PORT);

// Console will print the message
console.log('Server running at http://127.0.0.1:' + PORT + '/');
