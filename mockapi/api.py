from flask import Flask
from flask import redirect, abort
from flask import make_response
import json


import os


app = Flask(__name__)


@app.route('/mockapi/<apikey>')
def tema_mockapi(apikey):
    with open('k_rg1s0lsu.json','r') as f:
        ret = f.read()
    #processar
    ret2 = json.loads(ret)
    return make_response(ret2, 200)


if __name__ == '__main__':
    print("="*60)
    print("\n\nusar como endpoint http://127.0.0.1/mockapi/k_rg1s0lsu")
    print("para evitar a limitacao da api free de 100 acessos diarios.")
    print("APENAS DESENVOLVIMENTO NAO USAR EM PRODUCAO\n\n")
    print("="*60)
    app.run()

