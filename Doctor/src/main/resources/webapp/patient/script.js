document.getElementById("patientForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const patientData = {
        name: document.getElementById("patientName").value,
        address: document.getElementById("address").value,
        age: parseInt(document.getElementById("age").value),
        disease: document.getElementById("disease").value,
        doctorId: document.getElementById("doctorId").value,
        gender: document.getElementById("gender").value
    };

    fetch("http://localhost:8081/patient/save", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(patientData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Failed to register patient.");
        }
        if (response.status === 201) {
            if (response.body.getReader) {
                return response.text();
            } else {
                return Promise.resolve(null);
            }
        } else {
            throw new Error("Unexpected status code: " + response.status);
        }
    })
    .then(data => {
        if (data === null) {
            document.getElementById("message").textContent = "Patient registered successfully!";
            document.getElementById("message").style.color = "green";
            document.getElementById("patientForm").reset();
        } else if (data === "") {
            document.getElementById("message").textContent = "Patient registered successfully!";
            document.getElementById("message").style.color = "green";
            document.getElementById("patientForm").reset();
        } else {
            throw new Error("Unexpected response format.");
        }
    })
    .catch(error => {
        document.getElementById("message").textContent = "Error: " + error.message;
        document.getElementById("message").style.color = "red";
    });
});