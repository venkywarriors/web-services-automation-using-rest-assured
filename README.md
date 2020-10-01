```
import requests
import json

def pretty_print_request(request):
    print( '\n{}\n{}\n\n{}\n\n{}\n'.format(
        '-----------Request----------->',
        request.method + ' ' + request.url,
        '\n'.join('{}: {}'.format(k, v) for k, v in request.headers.items()),
        request.body)
    )

def pretty_print_response(response):
    print('\n{}\n{}\n\n{}\n\n{}\n'.format(
        '<-----------Response-----------',
        'Status code:' + str(response.status_code),
        '\n'.join('{}: {}'.format(k, v) for k, v in response.headers.items()),
        response.text)
    )         
    
def test_post_headers_body_json():
    url = 'https://httpbin.org/post'
    
    # Additional headers.
    headers = {'Content-Type': 'application/json' } 

    # Body
    payload = {'key1': 1, 'key2': 'value2'}
    
    # convert dict to json by json.dumps() for body data. 
    resp = requests.post(url, headers=headers, data=json.dumps(payload,indent=4))       
    
    # Validate response headers and body contents, e.g. status code.
    assert resp.status_code == 200
    resp_body = resp.json()
    assert resp_body['url'] == url
    
    pretty_print_request(resp.request)
    pretty_print_response(resp)
    **********************************************************************
    # pytest -sv
test_post_headers_body_json_pprint.py::test_post_headers_body_json
-----------Request----------->
POST https://httpbin.org/post

User-Agent: python-requests/2.22.0
Accept-Encoding: gzip, deflate
Accept: */*
Connection: keep-alive
Content-Length: 39

{
    "key1": 1,
    "key2": "value2"
}


<-----------Response-----------
Status code:200

Access-Control-Allow-Credentials: true
Access-Control-Allow-Origin: *
Content-Encoding: gzip
Content-Type: application/json
Date: Thu, 11 Jul 2019 06:20:34 GMT
Referrer-Policy: no-referrer-when-downgrade
Server: nginx
X-Content-Type-Options: nosniff
X-Frame-Options: DENY
X-XSS-Protection: 1; mode=block
Content-Length: 264
Connection: keep-alive

{
  "args": {},
  "data": "{\n    \"key1\": 1,\n    \"key2\": \"value2\"\n}",
  "files": {},
  "form": {},
  "headers": {
    "Accept": "*/*",
    "Accept-Encoding": "gzip, deflate",
    "Content-Length": "39",
    "Host": "httpbin.org",
    "User-Agent": "python-requests/2.22.0"
  },
  "json": {
    "key1": 1,
    "key2": "value2"
  },
  "origin": "103.115.210.48, 103.115.210.48",
  "url": "https://httpbin.org/post"
}
```
