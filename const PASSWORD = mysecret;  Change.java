const PASSWORD = "mysecret"; // Change this to your own password

function login() {
  const input = document.getElementById("password").value;
  if (input === PASSWORD) {
    document.getElementById("login-screen").style.display = "none";
    document.getElementById("diary-app").style.display = "block";
    loadEntries();
  } else {
    alert("Incorrect password!");
  }
}

function logout() {
  document.getElementById("diary-app").style.display = "none";
  document.getElementById("login-screen").style.display = "block";
}

function saveEntry() {
  const text = document.getElementById("entry-text").value;
  if (!text) return;
  const date = new Date().toLocaleString();
  const entry = { date, text };
  const entries = JSON.parse(localStorage.getItem("diaryEntries") || "[]");
  entries.unshift(entry);
  localStorage.setItem("diaryEntries", JSON.stringify(entries));
  document.getElementById("entry-text").value = "";
  loadEntries();
}

function loadEntries() {
  const entries = JSON.parse(localStorage.getItem("diaryEntries") || "[]");
  const container = document.getElementById("entries");
  container.innerHTML = "";
  entries.forEach(entry => {
    const div = document.createElement("div");
    div.className = "entry";
    div.innerHTML = `<h3>${entry.date}</h3><p>${entry.text}</p>`;
    container.appendChild(div);
  });
}