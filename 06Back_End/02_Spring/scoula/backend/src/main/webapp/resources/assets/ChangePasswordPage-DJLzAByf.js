import{u as h,a as b,r as P,c as v,b as y,o as i,d as u,e as s,w as r,v as d,t as k,f as g,g as l,h as x}from"./index-BRPOkSvz.js";import{a as V}from"./authApi-DS6QQNkg.js";const S={class:"mt-5 mx-auto",style:{width:"500px"}},B=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-lock"}),l(" 비밀번호 변경 ")],-1),I={class:"mb-3"},N=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),l(" 이전 비밀번호: ")],-1),U={class:"mb-3"},A=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),l(" 새 비밀번호: ")],-1),C={class:"mb-3"},D=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),l(" 새 비밀번호 확인: ")],-1),E={key:0,class:"text-danger"},M=["disabled"],T=s("i",{class:"fa-solid fa-check"},null,-1),z={__name:"ChangePasswordPage",setup(R){const p=h(),w=b(),o=P({username:w.username,oldPassword:"",newPassword:"",newPassword2:""}),m=v(()=>!o.oldPassword||!o.newPassword||!o.newPassword2),a=y(""),f=()=>a.value="",n=()=>a.value="",_=async()=>{if(o.newPassword!=o.newPassword2){a.value="새 비밀번호가 일치하지 않습니다.";return}try{await V.changePassword(o),alert("비밀번호를 수정했습니다."),p.push({name:"profile"})}catch(c){a.value=c.response.data}};return(c,e)=>(i(),u("div",S,[B,s("form",{onSubmit:x(_,["prevent"])},[s("div",I,[N,r(s("input",{type:"password",class:"form-control",placeholder:"이전 비밀번호","onUpdate:modelValue":e[0]||(e[0]=t=>o.oldPassword=t),onInput:f},null,544),[[d,o.oldPassword]])]),s("div",U,[A,r(s("input",{type:"password",class:"form-control",placeholder:"새 비밀번호","onUpdate:modelValue":e[1]||(e[1]=t=>o.newPassword=t),onInput:n},null,544),[[d,o.newPassword]])]),s("div",C,[D,r(s("input",{type:"password",class:"form-control",placeholder:"새 비밀번호 확인","onUpdate:modelValue":e[2]||(e[2]=t=>o.newPassword2=t),onInput:n},null,544),[[d,o.newPassword2]])]),a.value?(i(),u("div",E,k(a.value),1)):g("",!0),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:m.value},[T,l(" 확인 ")],8,M)],32)]))}};export{z as default};
