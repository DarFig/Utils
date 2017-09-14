// reverse string

function reverseString(str) {
  return str.split("").reverse().join("");
}

//factorialize

function factorialize(num) {
  if(num == 0) return 1;
  return num*factorialize(num-1);
}

//if(palindrome)

function palindrome(str) {
  str = str.toLowerCase().replace(/([^a-z0-9])+/g,"");
  var revStr = reverseString(str);
  
  if(str == revStr) return true;
  return false;
}
