import Vue from 'vue';

Vue.filter('dateformatByLong', (date) => {
  return Moment(new Date(date)).format('YYYY-MM-DD HH:mm:ss');
});

Vue.filter('dateformatByDate', (date) => {
  return Moment(date).format('YYYY-MM-DD HH:mm:ss');
});


