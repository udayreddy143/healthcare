document.getElementById("doctorForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const doctorData = {
        name: document.getElementById("doctorName").value,
        specialization: document.getElementById("specialization").value,
        experience: parseFloat(document.getElementById("experience").value)
    };

    fetch("http://localhost:8084/doctor/storedetails", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(doctorData)
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        }
        throw new Error("Failed to register doctor.");
    })
    .then(data => {
        document.getElementById("message").textContent = "Doctor registered successfully!";
        document.getElementById("doctorForm").reset();
    })
    .catch(error => {
        document.getElementById("message").textContent = "Error: " + error.message;
        document.getElementById("message").style.color = "red";
    });
});
