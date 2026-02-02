# Hello Papang



## 가. 프로젝트명

**헬로파팡(HelloPapang)**: 영어로 안녕을 뜻하는 ***Hello***와 필리핀어로 아버지를 뜻하는 ***Papang***을 합쳐서 '안녕 아빠'라는 의미로 만들었다.

 

## 나. 개요

Hello Papang은 개발자 부트캠프에서 팀 프로젝트로 진행했던 육아 대디 커뮤니티 웹 서비스이다. 

로그인, 메인 페이지, 게시판 등 웹 서비스 핵심 기능 중심으로 구현하였다. 본 프로젝트에서는 기존에 사용했던 소스코드를 현업에서 사용하는 코드 구조를 기반으로 재구축하고, 기능 고도화를 진행하였다. 특히 관리자 메뉴는 현업 프로젝트에서 직접 구현했던 경험을 바탕으로 설계하였으며, 당시 아쉬웠던 보안 및 권한 관리 기능을 보완하여 구현하였다. 

요건 정의, 환경 설정, 개발, 배포까지 시스템 구축의 전 과정을 혼자 진행하며 웹 서비스 전반에 대한 이해도를 높이고자 하였다. 개발 완료 후, AWS를 활용해 서버를 배포하고 도메인을 구매하여 실제 서비스 환경과 유사하게 구성하였다.



## 다. 개발 및 배포 환경

<table>    
    <tbody>
        <tr>
            <th rowspan="7">&nbsp;&nbsp;&nbsp;&nbsp;S/W&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                OS
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </th>            
            <td>
                개발: Windows 10 Home
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <br>
                배포: Amazon Linux 2023
            </td>            
        </tr>
        <tr>
            <th>서버</th>
            <td>Tomcat 8.5</td>        
        </tr>   
        <tr>
            <th>데이터베이스</th>
            <td>MySQL 8.0</td>        
        </tr>          
        <tr>
            <th>빌드 도구</th>            
            <td>Maven 3.8</td>        
        </tr>  
         <tr>
            <th>개발 언어</th>
            <td>Java 11, HTML5, JavaScript, CSS</td>        
        </tr>   
        <tr>
            <th>
                라이브러리/
                <br>
                프레임워크
            </th> 
           <td>
               프론트엔드: Bootstrap5, jQuery, Ajax
               <br>
			   백엔드: Spring Framework 5
            </td>        
        </tr>   
        <tr>
            <th>IDE</th>
            <td>Eclipse 2022-09 (4.25.0)</td>        
        </tr> 
        <tr>
            <th rowspan="3">H/W</th>
            <th>프로세서</th>    
            <td>
                개발: Intel Core i5-10210
                <br>
                배포: 1 vCPU
            </td>            
        </tr>
        <tr>
            <th>메모리</th>  
            <td>
                개발: 16GB
                <br>
                배포: 1GB
            </td>        
        </tr>   
        <tr>
            <th>보조 기억장치</th>   
            <td>
                개발: SSD 256GB
                <br>
                배포: SSD 8GB
            </td>        
        </tr>  
       <tr>
            <th>협업 툴</th>
            <th colspan="2">GitHub</th>          
        </tr>        
    </tbody>
</table>     



## 라. 산출물

<a href="./산출물/완료보고서/HelloPapang_완료보고서.pdf">HelloPapang_완료보고서.pdf</a>

<a href="./산출물/사용자 매뉴얼/HelloPapang_사용자 매뉴얼.pdf">HelloPapang_사용자 매뉴얼.pdf</a>

<a href="./산출물/요구사항 명세서/HelloPapang_요구사항_명세서.xlsx">HelloPapang_요구사항_명세서.xlsx</a>

<a href="./산출물/테이블 명세서/HelloPapang_테이블 명세서.xlsx">HelloPapang_테이블 명세서.xlsx</a>

