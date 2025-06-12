document.addEventListener('DOMContentLoaded', function (){
    const filterForm = document.getElementById('tipeKamarFilter');
    const kamarListContainer = document.getElementById('kamarListContainer');
    const emptyMessage = document.getElementById('noResultsMessage');

    const filters = {
        harga : {input : filterForm.querySelector('select[name="harga"]')},
        token : {input : filterForm.querySelector('select[name="token"]')},
        orang : {input : filterForm.querySelector('select[name="orang"]')}
    }

    async function fetchKamar(){
        const formData = new FormData(filterForm);
        const harga = formData.get('harga');
        const token = formData.get('token');
        const orang = formData.get('orang');

        let apiUrl = '/kamar/tipe-kamar';
        const params = new URLSearchParams();

        if (harga){
            params.append('harga', harga);
        }
        if (token){
            params.append('token', token);
        }
        if (orang){
            params.append('orang', orang);
        }
        if (params.toString()) {
            apiUrl += '?' + params.toString();
        }

        try{
            kamarListContainer.innerHTML = '<p class="text-center text-gray-500 col-span-full py-10">Memuat kamar...</p>';
            emptyMessage.classList.add('hidden');

            const response = await fetch(apiUrl);

            if (!response.ok) {
                throw new Error("Error")
            }

            const listKamar = await response.json();

            kamarListContainer.innerHTML='';

            if (listKamar.length === 0){
                emptyMessage.classList.remove('hidden');
            } else {
                emptyMessage.classList.add('hidden');
                listKamar.forEach(kamar => {
                    const cardKamar = document.createElement('div');
                    cardKamar.className = "mb-12 flex flex-col lg:flex-row w-full max-w-[1230px] mx-auto p-6 items-center gap-8 bg-white rounded-[20px] shadow-md"

                    const status = kamar.status ? 'Tersedia' : 'Penuh';
                    const statusClass = kamar.status ? 'bg-[#588157]' : 'bg-red-500';

                    const imageKamar = `
                        <div class="relative w-full md:w-[45%] h-56 md:h-auto overflow-hidden">
                            <img src="${kamar.imagePath || 'https://via.placeholder.com/400x200?text=Kamar+Image'}" alt="${kamar.jenisKamar}" class="w-full h-full object-cover">
                            <div class="absolute bottom-4 left-4 ${statusClass} text-white font-work-sans font-semibold text-base py-2 px-4 rounded-[10px] shadow-md">
                                ${statusText}
                            </div>
                        </div>
                    `;

                    const contentKamar = document.createElement('div');
                    contentKamar.className = "flex flex-col gap-4 w-full";
                    contentKamar.innerHTML = `
                        <h3 class="text-[#073937] font-opensans text-lg lg:text-[24px] font-semibold uppercase leading-[27.9px]">
                            ${kamar.jenisKamar}
                        </h3>
                        <p class="text-[#073937] font-opensans text-sm lg:text-[16px] font-normal leading-[27.9px]">
                            ${kamar.desc}
                        </p>
                        <h4 class="text-[#073937] font-opensans text-sm lg:text-[16px] font-semibold">
                            Fasilitas Kamar
                        </h4>
                        <p class="text-[#073937] font-opensans text-sm lg:text-[16px] font-normal leading-[27.9px]">
                            ${kamar.fasilitas}
                        </p>
                        <h4 class="text-[#073937] font-opensans text-sm lg:text-[16px] font-semibold">
                            Harga
                        </h4>
                    `;
                })
            }

        } catch (error) {
            console.error('Error fetching kamar data:', error);
            kamarListContainer.innerHTML = '<p class="text-red-500 text-center col-span-full py-10">Gagal memuat data kamar. Silakan coba lagi.</p>';
        }
    }
})