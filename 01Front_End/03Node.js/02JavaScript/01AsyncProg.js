function displayA() {
  console.log('A');
}

function displayB() {
  setTimeout(() => {
    console.log('D');
  }, 2000);
  console.log('B');
}

function displayC() {
  console.log('C');
}

displayA();
displayB();
displayC();
