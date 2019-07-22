import Vue from 'vue';

Vue.filter('dateformatByLong', (date) => {
  if(date < 1) {
    return date;
  }

  return Moment(new Date(date)).format('YYYY-MM-DD HH:mm:ss');
});

Vue.filter('dateformatByDate', (date) => {
  return Moment(date).format('YYYY-MM-DD HH:mm:ss');
});


