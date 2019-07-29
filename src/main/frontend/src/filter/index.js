import Vue from 'vue';

Vue.filter('dateformatByLong', (date) => {
  if(date < 1) {
    return date;
  }

  return Moment(new Date(date)).format('YYYY-MM-DD HH:mm:ss');
});

Vue.filter('dateByLong', (date) => {
  if(date < 1) {
    return date;
  }

  const dateTime = Moment(new Date(date)).format('YYYY-MM-DD HH:mm:ss');
  return _.split(dateTime, ' ')[0];
});

Vue.filter('timeByLong', (date) => {
  if(date < 1) {
    return '';
  }

  const dateTime = Moment(new Date(date)).format('YYYY-MM-DD HH:mm:ss');
  return _.split(dateTime, ' ')[1];
});



Vue.filter('dateformatByDate', (date) => {
  return Moment(date).format('YYYY-MM-DD HH:mm:ss');
});




