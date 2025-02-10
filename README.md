# DeepSeek AI Chatbot 🧠🤖  

This project is a **web-based chatbot** that allows users to ask questions, and it responds using the **DeepSeek R1 model** based on a given document. The backend provides an API to process user queries and stream responses in real time.

---

## 🚀 Features  
- **Takes user input** via a simple web interface  
- **Uses DeepSeek R1 model** to generate responses  
- **Streams responses in real-time** for a smooth user experience  
- **REST API endpoint** for querying  

---

## 🛠️ Tech Stack  
- **Frontend:** HTML, CSS, JavaScript  
- **Backend:** Java (Spring Boot)  
- **AI Model:** DeepSeek R1  

---

## 📌 API Endpoint  

### `GET /ai/stream?query=<question>`  
Sends a user query to the AI and streams the response.

#### **Request Example:**  
```sh
GET http://localhost:8080/ai/stream?query=What is AI?
```

![image](https://github.com/user-attachments/assets/13170b25-04cc-4768-99e9-9a66243d25e4)


