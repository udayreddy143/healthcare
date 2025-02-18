document.addEventListener("DOMContentLoaded", function () {
    fetchDoctors();
});

function fetchDoctors() {
    fetch("http://localhost:8084/doctor/getDoctordetails")
        .then(response => response.json())
        .then(doctors => {
            const doctorList = document.getElementById("doctorList");
            doctorList.innerHTML = "";

            doctors.forEach(doctor => {
                const doctorCard = document.createElement("div");
                doctorCard.classList.add("doctor-card");

                doctorCard.innerHTML = `
                    <h3>Dr. ${doctor.name}</h3>
                    <p><strong>Specialization:</strong> ${doctor.specialization}</p>
                    <p><strong>Experience:</strong> ${doctor.experience} years</p>
                    <p><strong>DoctorId:</strong> ${doctor.id}</p>

                    <button class="get-slot-btn" onclick="redirectToSlots(${doctor.id})">Get Slots</button>
                `;

                doctorList.appendChild(doctorCard);
            });
        })
        .catch(error => console.error("Error fetching doctors:", error));
}

function redirectToSlots(doctorId) {
    window.location.href = `slots.html?doctorId=${doctorId}`;
}
