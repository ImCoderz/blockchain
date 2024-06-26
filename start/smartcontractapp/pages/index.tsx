import ContractCard from "../components/ContractCard";
import { ERC1155_CONTRACT_ADDRESS, ERC20_CONTRACT_ADDRESS, ERC721_CONTRACT_ADDRESS, PROFILE_STATUS_CONTRACT_ADDRESS, STAKING_CONTRACT_ADDRESS, TIP_JAR_CONTRACT_ADDRESS } from "../constants/addresses";
import styles from "../styles/Home.module.css";
import { NextPage } from "next";

const Home: NextPage = () => {
  return (
    <main className={styles.main}>
      <div className={styles.container}>
        <div className={styles.header}>
          <h1 className={styles.title}>
            My{" "}
            <span className={styles.gradientText0}>
                Contracts.
            </span>
          </h1>

          <p className={styles.description}>
            Select a contract to interact with
          </p>

        </div>

        <div className={styles.grid}>
          <ContractCard
            href="/project/erc20"
            contractAddress={ERC20_CONTRACT_ADDRESS}
            title="ERC20 =>"
            description="Claim ERC20 Token"

          />
          <ContractCard
            href="/"
            contractAddress={ERC721_CONTRACT_ADDRESS}
            title="ERC721 =>"
            description="Claim ERC721 Token"

          />
            <ContractCard
              href="/"
              contractAddress={ERC1155_CONTRACT_ADDRESS}
              title="ERC1155 =>"
              description="Claim ERC1155 Token"
  
            />
          <ContractCard
            href="/"
            contractAddress={STAKING_CONTRACT_ADDRESS}
            title="Staking =>"
            description="Stake your ERC721 to earn ERC20 Token"

          />
          <ContractCard
            href="/"
            contractAddress={PROFILE_STATUS_CONTRACT_ADDRESS}
            title="Profile status =>"
            description="Update yur profile status on the Blockchain"

          />
          <ContractCard
            href="/"
            contractAddress={TIP_JAR_CONTRACT_ADDRESS}
            title="Tip Jar =>"
            description="Leave a tip on the Blockchain"

          />
        </div>
      </div>
    </main>
  );
};

export default Home;
