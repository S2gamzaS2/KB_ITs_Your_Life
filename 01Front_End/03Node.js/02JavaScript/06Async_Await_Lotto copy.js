const lotto = new Promise((resolve, reject) => {
  console.log('나 로또 살까?');
  console.log('숫자가 5이상이면 사고 미만이면 사지마~');
  setTimeout(() => {
    const rand = parseInt(Math.random() * 10);
    console.log(`나온 숫자는~ ${rand}!`);
    if (rand >= 5) resolve('로또 사자!');
    else reject('아 망했어요');
  }, 3000);
});

async function AsyncAwait() {
  try {
    const data = await lotto;
    console.log(data);
  } catch (err) {
    console.log(err);
  }
}

AsyncAwait();
