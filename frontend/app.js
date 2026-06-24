const API_BASE_URL = 'http://localhost:8081/api';

// Handle Eligibility Form Submission
const eligibilityForm = document.getElementById('eligibilityForm');

if (eligibilityForm) {
    eligibilityForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        
        const loading = document.getElementById('loading');
        const submitBtn = eligibilityForm.querySelector('button');
        const resultContent = document.getElementById('resultContent');

        const formData = {
            name: document.getElementById('name').value,
            age: parseInt(document.getElementById('age').value),
            gender: document.getElementById('gender').value,
            occupation: document.getElementById('occupation').value,
            income: parseFloat(document.getElementById('income').value),
            category: document.getElementById('category').value,
            state: document.getElementById('state').value,
            contactNumber: document.getElementById('contactNumber').value
        };

        loading.classList.remove('hidden');
        submitBtn.disabled = true;

        try {
            const response = await fetch(`${API_BASE_URL}/check-eligibility`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            if (!response.ok) {
                throw new Error('Server error');
            }

            const data = await response.json();
            displayResult(data);
        } catch (error) {
            console.error('Error fetching eligibility:', error);
            resultContent.innerHTML = `<p class="status-not-eligible">Error connecting to the server. Is the Spring Boot backend running on port 8081?</p>`;
        } finally {
            loading.classList.add('hidden');
            submitBtn.disabled = false;
        }
    });
}

function displayResult(data) {
    const resultContent = document.getElementById('resultContent');
    
    let html = '';
    
    // Success banner indicating data has been stored
    html += `
        <div class="success-banner" style="background-color: #ecfdf5; color: #065f46; border: 1px solid #a7f3d0; padding: 0.75rem 1rem; border-radius: 0.5rem; margin-bottom: 1.5rem; font-weight: 600; font-size: 0.9rem; text-align: center; display: flex; align-items: center; justify-content: center; gap: 8px;">
            <span style="font-size: 1.2rem;">✓</span> Profile submitted and successfully saved to the database!
        </div>
    `;

    if (data.eligible) {
        html += `
            <div class="result-status status-eligible" style="font-size: 1.4rem; font-weight: 700; color: #10b981; margin-bottom: 0.5rem;">Congratulations!</div>
            <p style="margin-bottom: 1.5rem; color: #64748b; font-size: 0.95rem;">${data.message}</p>
            <div class="eligible-schemes" style="display: grid; gap: 1.25rem;">
        `;
                 
        data.eligibleSchemes.forEach(scheme => {
            html += `
                <div class="scheme-item" style="background: #ffffff; padding: 1.25rem; border-radius: 0.75rem; border: 1px solid #e2e8f0; border-left: 5px solid #2563eb; box-shadow: 0 4px 6px -1px rgba(0,0,0,0.05); display: flex; flex-direction: column; gap: 0.75rem;">
                    <div style="display: flex; justify-content: space-between; align-items: flex-start; gap: 1rem;">
                        <h4 style="margin: 0; font-size: 1.1rem; color: #0f172a; font-weight: 700;">${scheme.schemeName}</h4>
                        <span class="category-badge" style="background: #eff6ff; color: #2563eb; padding: 0.2rem 0.6rem; border-radius: 9999px; font-size: 0.75rem; font-weight: 600; white-space: nowrap;">${scheme.category}</span>
                    </div>
                    <p style="margin: 0; color: #475569; font-size: 0.9rem; line-height: 1.5;">${scheme.description}</p>
                    <div style="background: #f8fafc; padding: 0.75rem; border-radius: 0.5rem; font-size: 0.85rem; color: #334155; border: 1px solid #e2e8f0;">
                        <strong style="color: #0f172a;">Eligibility Guidelines:</strong> ${scheme.eligibility}
                    </div>
                    <a href="${scheme.officialWebsiteUrl}" target="_blank" class="btn btn-primary" style="align-self: flex-start; padding: 0.5rem 1rem; font-size: 0.85rem; text-decoration: none; border-radius: 0.375rem; font-weight: 600; text-align: center;">View Site</a>
                </div>
            `;
        });
        
        html += `</div>`;
    } else {
        html += `
            <div class="result-status status-not-eligible" style="font-size: 1.4rem; font-weight: 700; color: #ef4444; margin-bottom: 0.5rem;">No Schemes Matched</div>
            <p style="color: #64748b; font-size: 0.95rem;">${data.message}</p>
        `;
    }
    
    resultContent.innerHTML = html;
}

// Fetch all schemes for Schemes page
async function fetchAllSchemes() {
    const schemesList = document.getElementById('schemesList');
    if (!schemesList) return;

    try {
        const response = await fetch(`${API_BASE_URL}/schemes`);
        if (!response.ok) throw new Error('Failed to fetch schemes');
        
        const schemes = await response.json();
        
        if (schemes.length === 0) {
            schemesList.innerHTML = `<p>No schemes available at the moment. Please check database configuration and ensure sample data is inserted.</p>`;
            return;
        }

        let html = '';
        schemes.forEach(scheme => {
            html += `
                <div class="card scheme-item" style="display: flex; flex-direction: column; justify-content: space-between; height: 100%; border: 1px solid #e2e8f0; border-left: 5px solid #2563eb; background: #ffffff; padding: 1.5rem; border-radius: 0.75rem; box-shadow: 0 4px 6px -1px rgba(0,0,0,0.05); gap: 1rem;">
                    <div>
                        <div style="display: flex; justify-content: space-between; align-items: flex-start; gap: 1rem; margin-bottom: 0.5rem;">
                            <h4 style="margin: 0; font-size: 1.15rem; color: #0f172a; font-weight: 700;">${scheme.schemeName}</h4>
                            <span class="category-badge" style="background: #eff6ff; color: #2563eb; padding: 0.2rem 0.6rem; border-radius: 9999px; font-size: 0.75rem; font-weight: 600; white-space: nowrap;">${scheme.category}</span>
                        </div>
                        <p style="margin: 0 0 1rem 0; color: #475569; font-size: 0.925rem; line-height: 1.5;">${scheme.description}</p>
                        <div style="background: #f8fafc; padding: 0.75rem; border-radius: 0.5rem; font-size: 0.85rem; color: #334155; border: 1px solid #e2e8f0;">
                            <strong style="color: #0f172a;">Eligibility Guidelines:</strong> ${scheme.eligibility}
                        </div>
                    </div>
                    <a href="${scheme.officialWebsiteUrl}" target="_blank" class="btn btn-primary" style="align-self: flex-start; padding: 0.5rem 1rem; font-size: 0.85rem; text-decoration: none; border-radius: 0.375rem; font-weight: 600; text-align: center; width: auto;">View Site</a>
                </div>
            `;
        });

        schemesList.innerHTML = html;
    } catch (error) {
        console.error('Error fetching schemes:', error);
        schemesList.innerHTML = `<p style="color: red;">Error connecting to the server. Is the Spring Boot backend running on port 8081?</p>`;
    }
}
