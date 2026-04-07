import http from 'k6/http';
import { check, sleep } from 'k6';
import { Counter } from 'k6/metrics';

let normalReqs = new Counter('normal_reqs');
let virtualReqs = new Counter('virtual_reqs');

export let options = {
    vus: 500,
    duration: '15s',
};

export default function () {
    // Rota normal
    let resNormal = http.get('http://localhost:8080/api/normal');
    if (resNormal.status === 200) normalReqs.add(1);

    // Rota virtual
    let resVirtual = http.get('http://localhost:8080/api/virtual');
    if (resVirtual.status === 200) virtualReqs.add(1);

    sleep(0.03);
}