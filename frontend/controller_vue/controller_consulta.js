const vapp = {
  data() {
    return {
      tituloA: "Consultar CEP",
      cep: "",
      local: "",
      bairro: "",
      cidade: "",
      errorMessage: "",
      showSuccessMessage: false,
    };
  },
  methods: {
    buscarEndereco() {
      let endpoint = `http://localhost:8080/apis/consultarCep/${this.cep}`;
      axios
        .get(endpoint)
        .then((response) => {
          this.local = "";
          this.bairro = "";
          this.cidade = "";
          this.errorMessage= "";
          this.obterDetalhesEndereco(response.data);
          this.showSuccessMessage = true;
          setTimeout(() => {
            this.showSuccessMessage = false;
          }, 10000);
        })
        .catch((error) => {
          console.log(error.response);
          let errorMessage =
            "Erro ao consultar o CEP. Verifique se o CEP está correto e tente novamente.";
          this.errorMessage = errorMessage;
          this.showSuccessMessage = false;
        });
    },
    
    obterDetalhesEndereco(response) {
      const enderecoParts = response.enderecoCompleto.split(", ");
    
      if (enderecoParts.length === 3) {
        this.local = enderecoParts[0];
        this.bairro = enderecoParts[1];
        this.cidade = enderecoParts[2];
        setTimeout(() => {
          this.showSuccessMessage = false;
        }, 10000);
      } else {
        this.local = "";
        this.bairro = "";
        this.cidade = "";
      }
    },
    
  },
  template: `
    <div id="app" class="container mt-3">
      <div class="card">
        <div class="card-body">
          <h2 class="card-title">{{ tituloA }}</h2>
          <div v-if="errorMessage" class="alert alert-danger mt-3">
            {{ errorMessage }}
          </div>
          <div v-if="showSuccessMessage" class="alert alert-success mt-3">
            CEP consultado com sucesso! O endereço foi preenchido.
          </div>
          <form id="formtipo">
            <div class="mb-3">
              <label for="cep" class="form-label">CEP</label>
              <input type="text" v-model="cep" id="cep" class="form-control" placeholder="CEP" />
            </div>
            <div class="mb-3">
              <label for="local" class="form-label">Local</label>
              <input type="text" v-model="local" id="local" class="form-control" disabled placeholder="Endereço Local" />
            </div>
            <div class="mb-3">
              <label for="bairro" class="form-label">Bairro</label>
              <input type="text" v-model="bairro" id="bairro" class="form-control" disabled placeholder="Bairro" />
            </div>
            <div class="mb-3">
              <label for="cidade" class="form-label">Cidade</label>
              <input type="text" v-model="cidade" id="cidade" class="form-control" disabled placeholder="Cidade" />
            </div>
          </form>
          <button @click="buscarEndereco()" class="btn btn-primary">Buscar</button>
        </div>
      </div>
    </div>
  `,
};

Vue.createApp(vapp).mount("#app");
