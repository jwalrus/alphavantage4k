# alphavantage4k

This is a simple wrapper around the [Alpha Vantage](https://www.alphavantage.co/documentation/) API. 

This project is divided into two modules, `data` and `http`. `data` is just a collection of data objects that can be used with `Jackson` to deserialize the API responses. The `http` project uses `http4k` to fetch the data. See the tests classes for example usage.
