package com.localgov.eligibilitychecker;

import com.localgov.eligibilitychecker.model.Scheme;
import com.localgov.eligibilitychecker.repository.SchemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EligibilityCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EligibilityCheckerApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(SchemeRepository schemeRepository) {
        return args -> {
            if (schemeRepository.count() == 0) {
                // Agriculture
                schemeRepository.save(new Scheme(
                    "PM-KISAN (Pradhan Mantri Kisan Samman Nidhi)",
                    "Agriculture",
                    "Financial assistance of ₹6,000 per year in three equal installments to small and marginal farmer families.",
                    "Small and marginal farmers with landholdings in their name.",
                    "https://pmkisan.gov.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Pradhan Mantri Fasal Bima Yojana (PMFBY)",
                    "Agriculture",
                    "Low-premium crop insurance scheme safeguarding farmers against natural calamities, pests, and diseases.",
                    "All farmers growing notified crops in notified areas, including tenant farmers.",
                    "https://pmfby.gov.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Kisan Credit Card (KCC)",
                    "Agriculture",
                    "Timely and flexible credit support for agricultural expenses, cultivation needs, and post-harvest maintenance.",
                    "All farmers, owner-cultivators, tenant farmers, and self-help groups.",
                    "https://www.ncard.org/"
                ));
                schemeRepository.save(new Scheme(
                    "Soil Health Card Scheme",
                    "Agriculture",
                    "Provides soil health cards indicating nutrient status and suggesting crop-wise fertilizer recommendations.",
                    "All farmers owning agricultural land in India.",
                    "https://soilhealth.dac.gov.in/"
                ));

                // Education
                schemeRepository.save(new Scheme(
                    "National Scholarship Portal (NSP)",
                    "Education",
                    "Centralized portal offering pre-matric, post-matric, and merit-cum-means scholarships for deserving students.",
                    "Students enrolled in recognized schools/universities with annual family income less than ₹2,50,000.",
                    "https://scholarships.gov.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Vidya Lakshmi Student Loan Scheme",
                    "Education",
                    "Single-window portal providing access to education loans and scholarships from multiple public and private banks.",
                    "Indian national students who have secured admission in higher education courses in India or abroad.",
                    "https://www.vidyalakshmi.co.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Free Education & Textbook Scheme (Samagra Shiksha)",
                    "Education",
                    "Ensures inclusive and equitable quality education from pre-school to senior secondary stage with free learning materials.",
                    "All school children aged 6 to 14 years.",
                    "https://education.gov.in/"
                ));

                // Women Welfare
                schemeRepository.save(new Scheme(
                    "Beti Bachao Beti Padhao (BBBP)",
                    "Women Welfare",
                    "Focuses on improving the child sex ratio, ensuring survival & protection of the girl child, and supporting her education.",
                    "All Indian families, especially those with newborn girl children.",
                    "https://wcd.nic.in/schemes/beti-bachao-beti-padhao-empathy-campaign"
                ));
                schemeRepository.save(new Scheme(
                    "Mahila Samman Savings Certificate",
                    "Women Welfare",
                    "Small savings scheme for women offering a fixed interest rate of 7.5% per annum for a 2-year tenure.",
                    "Any woman or girl child (represented by a guardian).",
                    "https://www.indiapost.gov.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Working Women Hostel Scheme",
                    "Women Welfare",
                    "Ensures safe and convenient accommodation for working women, along with daycare facilities for their children.",
                    "Working, single, widowed, or divorced women with monthly gross income not exceeding ₹50,000 (metro areas).",
                    "https://wcd.nic.in/schemes/working-women-hostel"
                ));

                // Healthcare
                schemeRepository.save(new Scheme(
                    "Ayushman Bharat (PM-JAY)",
                    "Healthcare",
                    "Cashless health cover up to ₹5 Lakhs per family per year for secondary and tertiary care hospitalization.",
                    "Low-income households identified via the Socio-Economic Caste Census (SECC) database.",
                    "https://pmjay.gov.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Pradhan Mantri Bhartiya Janaushadhi Pariyojana (PMBJP)",
                    "Healthcare",
                    "Provides high-quality generic medicines to all citizens at highly subsidized rates through dedicated outlets.",
                    "Open to all citizens of India.",
                    "http://janaushadhi.gov.in/"
                ));

                // Housing
                schemeRepository.save(new Scheme(
                    "Pradhan Mantri Awas Yojana (PMAY)",
                    "Housing",
                    "Affordable housing scheme aiming to provide eco-friendly, pucca houses with clean water, toilets, and electricity.",
                    "Families belonging to EWS (income < ₹3L), LIG (income < ₹6L), or MIG who do not own a pucca house in India.",
                    "https://pmaymis.gov.in/"
                ));

                // Senior Citizens
                schemeRepository.save(new Scheme(
                    "Pradhan Mantri Vaya Vandana Yojana (PMVVY)",
                    "Senior Citizens",
                    "Pension scheme offered by LIC providing guaranteed interest/returns to senior citizens.",
                    "Indian citizens aged 60 years and above.",
                    "https://www.licindia.in/"
                ));
                schemeRepository.save(new Scheme(
                    "Rashtriya Vayoshri Yojana",
                    "Senior Citizens",
                    "Scheme for providing physical aids and assisted-living devices to senior citizens belonging to the BPL category.",
                    "Senior citizens aged 60+ who belong to Below Poverty Line (BPL) families or have monthly income under ₹15,000.",
                    "https://socialjustice.gov.in/"
                ));

                // Employment
                schemeRepository.save(new Scheme(
                    "MGNREGA (Mahatma Gandhi National Rural Employment Guarantee)",
                    "Employment",
                    "Guarantees 100 days of manual wage employment in a financial year to rural households.",
                    "Adult members of rural households willing to do unskilled manual work.",
                    "https://nrega.nic.in/"
                ));
                schemeRepository.save(new Scheme(
                    "PM SVANidhi",
                    "Employment",
                    "Micro-credit scheme providing collateral-free working capital loans of up to ₹10,000 to street vendors.",
                    "Street vendors active in urban, semi-urban, or rural surrounding areas.",
                    "https://pmsvanidhi.mohua.gov.in/"
                ));

                System.out.println("Comprehensive sample government schemes initialized in database.");
            }
        };
    }
}
