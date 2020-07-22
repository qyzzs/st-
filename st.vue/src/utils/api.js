import axios from 'axios'
axios.interceptors.request.use(config => {
  // 添加请求头字段  --服务器判断请求头是否正确，filtter 驳回
  config.headers.Authorization = window.sessionStorage.getItem('token')
  // console.log(config)
  return config
})
axios.defaults.baseURL = 'http://localhost:8088/'
// const base = 'http://localhost:8077/'
export const postKeyValueRequest = (url, params) => {
  return axios({
    method: 'post',
    url: `${url}`,
    data: params,
    transformRequest: [function (data) {
      let ret = ''
      for (const i in data) {
        ret += encodeURIComponent(i) + '=' + encodeURIComponent(data[i]) + '&'
      }
      return ret
    }],
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}
export const postRequest = (url, params) => {
  return axios({
    method: 'post',
    url: `${url}`,
    data: params
  })
}
export const putRequest = (url, params) => {
  return axios({
    method: 'put',
    url: `${url}`,
    data: params
  })
}
export const getRequest = (url, params) => {
  console.log(params)
  return axios({
    method: 'get',
    url: `${url}`,
    params: params
  })
}
export const deleteRequest = (url, params) => {
  return axios({
    method: 'delete',
    url: `${url}`,
    params: params
  })
}
