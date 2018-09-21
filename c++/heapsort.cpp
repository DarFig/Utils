#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


int getHijoIzqPos(int padrePos){
  return 2*padrePos+1;
}
int getHijoDerPos(int padrePos){
  return 2*padrePos+2;
}
int getPadrePos(int n){
  return (n-1)/2;
}
template <typename T>
void heapsort(std::vector<T> &v){
  int final = v.size()-1;
  int p=0, i=0, d=0;
  T bux;
  while(final>0){
    p = getPadrePos(final);
  for(int j = 0; j<getPadrePos(final)+1; j++){
    i = getHijoIzqPos(p);
    d = getHijoDerPos(p);
    if(i<final+1 && v[p]<=v[i] && v[d]<v[i]){
      bux = v[i];
      v.erase(v.begin()+i);
      v.emplace(v.begin()+i, v[p]);
      v.erase(v.begin()+p);
      v.emplace(v.begin()+p, bux);

    }else if(d<final+1 && v[p]<v[d] && v[i]<v[d]){
      bux = v[d];
      v.erase(v.begin()+d);
      v.emplace(v.begin()+d, v[p]);
      v.erase(v.begin()+p);
      v.emplace(v.begin()+p, bux);
  
    }
    p--;
  }
  bux = v[0];
  v.erase(v.begin());
  v.emplace(v.begin(), v[final]);;
  v.erase(v.begin()+final);
  v.emplace(v.begin()+final, bux);
  final--;
}
/*for(int i = 0; i<v.size(); i++){
  cout<<v[i]<<endl;
}*/
}

int main(){
  vector<int> a;
  a.push_back(5);
  a.push_back(8);
  a.push_back(6);
  a.push_back(1);
  a.push_back(4);
  a.push_back(7);
  a.push_back(3);
  a.push_back(9);
  a.push_back(2);
  a.push_back(0);
  heapsort(a);
 for(int i = 0; i<a.size(); i++){
    cout<<(int)a[i]<<endl;
  }
  return 0;
}
