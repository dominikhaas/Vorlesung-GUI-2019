/**
 * Created by dominik.haas on 27.05.18.
 */
var message = "Hello ";

function sayHello(name) {
  console.log(message + name);
}

sayHello("Rosenheim");


function Greeter(name) {
  this.name = name;
};

Greeter.prototype.greet = function() {
  alert("Hello " + this.name);
}

var greeter = new Greeter("Rosenheim");


console.log("-------");
console.log('5' + 3);
console.log('5' - 3);
console.log([1, 2, 3] + [4, 5, 6]);


function getMessage() {
  return {
    message: 'Hello world'
  }
}
console.log(getMessage().message);


var promise = new Promise(function(resolve, reject) {
    resolve(1);
});

promise.then(function(val) {
    console.log(val); // 1
    return val + 2;
}).then(function(val) {
    console.log(val); // 3
});
